(ns chronograph.render
  (:require [quil.core :as q]))

(defn init []
  (q/frame-rate 60))

(defn clear []
  (q/background 255 0))

(defn draw [{{:keys [width height x y]} :dimensions}]
  (clear)
  (q/no-stroke)
  (q/fill 255 0 0 40)
  (q/rect x y width height))
