(ns chronograph.time
  (:require [chronograph.format :as format]))

(defn now []
  (js/Date.))

(defn part-of-the-day [t]
  (let [H (.getHours t)]
    (if (< H 12) "AM" "PM")))

(defn hours [t]
  (let [h (mod (.getHours t) 12)]
    (if (> h 0) h 12)))

(defn minutes [t]
  (.getMinutes t))

(defn seconds [t]
  (.getSeconds t))

(defn milliseconds [t]
  (.getMilliseconds t))

(defn thirds [t]
  (-> t milliseconds (/ 1000) (* 60) int))

(defn clock []
  (let [t (now)]
    (str (format/roman (hours t))
         " : "
         (format/roman (minutes t))
         " : "
         (format/roman (seconds t))
         " "
         (part-of-the-day t))))

