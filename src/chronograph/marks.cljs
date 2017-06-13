(ns chronograph.marks
  (:refer-clojure :exclude [take]))

(def all (for [section (range 2)
               block   (range 3)
               row     (range 10)
               group   (range 12)
               index   (range 5)]
           [section block row group index]))

(defn take [n]
  (clojure.core/take n all))

(comment (last (take 3600 marks)))
