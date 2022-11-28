(ns clojure-library.integration-test.tools
  "Tools for integration tests"
  (:require
            [clojure.test :refer :all]
            [clojure-library.webserver :refer [default-config]]
            [utils.data :refer [deep-merge]]
            [ring.adapter.jetty :refer :all]
            [integrant.core :as ig]
            [http.async.client :as http])
  )

(def port 3333)
(def app-url (str "http://localhost:" port))
(def test-config (deep-merge default-config {:webserver/jetty {:port port}}))

(defn init [system]
  (try
    (-> system
        (ig/prep)
        (ig/init))
    (catch clojure.lang.ExceptionInfo ex
      (clojure.pprint/pprint ex)
      (ig/halt! (:system (ex-data ex)))
      (throw (.getCause ex))))
  )

(defmacro with-server [binding & body]
  `(let [~(first binding) (init ~(second binding))]
     (try
       ~@body
       (finally (ig/halt! ~(first binding))))))

(defn http-get [url & {:keys [timeout] :or {timeout 1000}}]
  (with-open [client (http/create-client)]
    (let [response (http/GET client url)]
      {:status (-> (http/status response) :code)
       :body (-> response http/await http/string)}
      ))
  )
