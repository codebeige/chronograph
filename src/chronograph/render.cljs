(ns chronograph.render
  (:require [quil.core :as q]))

(defn init []
  (q/frame-rate 60)
  (q/color-mode :hsb))

(defn draw [state]
  (q/background 240)
  (q/fill (:color state) 255 255)
  (let [angle (:angle state)
        x (* 150 (q/cos angle))
        y (* 150 (q/sin angle))]
    (q/with-translation [(/ (q/width) 2)
                         (/ (q/height) 2)]
      (q/ellipse x y 100 100))))
