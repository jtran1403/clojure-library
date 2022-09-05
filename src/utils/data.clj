(ns utils.data)

(defn deep-merge
  [& maps]
  (if (every? map? maps) (apply merge-with deep-merge maps) (last maps)))
