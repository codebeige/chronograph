(ns chronograph.format)

(def roman-numerals
  {0    ""
   1    "I"
   4    "IV"
   5    "V"
   9    "IX"
   10   "X"
   40   "XL"
   50   "L"
   90   "XC"
   100  "C"
   400  "CD"
   500  "D"
   900  "CM"
   1000 "M"})

(defn roman [n]
  (loop [r ""
         n n]
    (if-let [v (roman-numerals n)]
      (str r v)
      (let [[k v] (->> roman-numerals
                       keys
                       (filter #(> n %))
                       last
                       (find roman-numerals))]
        (recur (str r v) (- n k))))))

(comment
 (roman 1)
)
