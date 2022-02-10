(ns clojure-library.book)

(def books [{:id 1
             :title "Romeo and Juliet"
             :author "William Shakespeare"
             :language :en
             :tags [:drama :tragedy :romance]
             :pages 336
             }
            {:id 2
             :title "Roméo et Juliette"
             :author "William Shakespeare"
             :language :fr
             :tags [:drama :tragedy :romance]
             :pages 192
             }
            {:id 3
             :title "Les Enquêtes d'Hercule Poirot"
             :author "Agatha Christie"
             :language :fr
             :tags [:detective :crime :thriller]
             :pages 224
             }
            {:id 4
             :title "Le Seigneur des anneaux : la communauté de l'anneau"
             :author "John Ronald Reuel Tolkien"
             :language :fr
             :tags [:fantasy :adventure]
             :pages 423
             }])

(comment
  (for [i (range 10)]
    i)
  (for [book books]
    (clojure.pprint/pprint book))
  (filter (fn [book] (= (:language book) :fr)) books)
  (map :title books)
  (reduce (fn [current_value book] (+ current_value (:pages book)))
          0 books))


(defn search-books-by-language [books language]
  (filter (fn [book] (= (:language book) language)) books))


(defn- get-author [book]
  (:author book))

(comment
  (filter #(= (:language %) :fr) books)
  (let [herge {:fullname "Georges Remi"
               :nickname "Hergé"
               :birth    {:date    1907
                          :country "Belgique"}}
        very-detailed-book {:comic  "Les Aventures de Tintin"
                            :title  "Le secret de la licorne"
                            :author herge}]
    (:country (:birth (:author very-detailed-book))))
  herge


  )
