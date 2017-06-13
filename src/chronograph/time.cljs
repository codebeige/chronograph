(ns chronograph.time)

(defn now []
  (js/Date.))

(defn milliseconds [t]
  (.getMilliseconds t))

(defn seconds [t]
  (.getSeconds t))

(defn thirds [t]
  (-> t milliseconds (/ 1000) (* 60) int))
