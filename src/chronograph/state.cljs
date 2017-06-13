(ns chronograph.state
  (:require [chronograph.dimensions :as dimensions]
            [chronograph.marks :as marks]
            [chronograph.time :as time]))

(defn current-count []
  (let [t (time/now)]
    (+ (* 60 (time/seconds t)) (time/thirds t))))

(defn init [w h]
  (assoc (dimensions/init w h) :marks []))

(defn tick [state]
  (assoc state :marks (marks/take (current-count))))
