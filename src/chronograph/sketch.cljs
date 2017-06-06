(ns chronograph.sketch
  (:require [chronograph.state :as state]
            [chronograph.render :as render]
            [quil.core :as quil]
            [quil.middleware :as middleware]))

(defn init []
  (render/init)
  (state/init))

(quil/defsketch chronograph
  :size [500 500]
  :setup init
  :update state/tick
  :draw render/draw
  :middleware [middleware/fun-mode])
