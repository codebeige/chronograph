(ns chronograph.state
  (:refer-clojure :exclude [update]))

(defn init []
  {:color 0
   :angle 0})

(defn tick [state]
  {:color (mod (+ (:color state) 0.7) 255)
   :angle (+ (:angle state) 0.1)})
