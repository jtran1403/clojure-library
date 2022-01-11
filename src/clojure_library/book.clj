(ns clojure-library.book)

"jean"                        ; string
12                            ; int
12.1
:nom                          ; keyword
{:nom "jean" :age 12}         ; map ⇔ une structure clé - valeur
[1 2 3 4]                     ; un type de collection
[1 "tata" nil 4.0]            ; une collection étrange mais valide

(def numbers [1 2 3])
(def letters #{:a :b "c" nil})
(def books [{:id 1
             :title "Romeo and Juliet"
             :author "William Shakespeare"
             :language :en
             :tags [:drama :tragedy :romance]
             }
            {:id 2
             :title "Roméo et Juliette"
             :author "William Shakespeare"
             :language :fr
             :tags [:drama :tragedy :romance]
             }
            {:id 3
             :title "Hercule Poirot"
             :author "Agatha Christie"
             :language :fr
             :tags [:detective :crime :thriller]
             }
            {:id 4
             :title "Le Seigneur des anneaux : la communauté de l'anneau"
             :author "John Ronald Reuel Tolkien"
             :language :fr
             :tags [:fantasy :adventure]
             }])
