(ns chronograph.render
  (:require [quil.core :as q]))

(defn init []
  (q/frame-rate 60))

(defn clear []
  (q/background 255 0))

(defn draw [{:keys [block
                    clock
                    font-size
                    group
                    length
                    margin
                    marks
                    offset
                    row
                    section
                    time
                    weight]}]
  (clear)
  (q/fill 197 186 182)
  (q/text-font (q/create-font "serif" font-size))
  (q/text-align :center :center)
  (apply q/text (into [time] clock))
  (q/stroke 57 7 13)
  (q/stroke-weight weight)
  (q/stroke-cap :square)
  (doseq [[s b r g i] marks]
    (let [x (+ (first margin) (* b block) (* g group) (* i offset))
          y (+ (second margin) (* s section) (* r row))]
      (if (< i 4)
        (q/line x y x (+ y length))
        (q/line (- x group) (+ y (* 0.5 row)) x (+ y (* 0.2 row)))))))
