(ns chronograph.sketch
  (:require [chronograph.state :as state]
            [chronograph.render :as render]
            [chronograph.viewport :as viewport]
            [quil.core :as quil]
            [quil.sketch :as sketch]
            [quil.middleware :as middleware]))

(defn setup []
  (render/init)
  (state/init))

(defn reset []
  (quil/sketch
    :host "chronograph"
    :size (viewport/size)
    :setup setup
    :update state/tick
    :draw render/draw
    :middleware [middleware/fun-mode]))

(defn init []
  (sketch/add-sketch-to-init-list {:fn reset})
  (viewport/on-resize! reset))
