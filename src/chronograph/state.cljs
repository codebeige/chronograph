(ns chronograph.state
  (:require [chronograph.dimensions :as dimensions]
            [quil.core :as q]))

(defn init []
  {:dimensions (dimensions/init (q/width) (q/height))})

(defn tick [state]
  state)
