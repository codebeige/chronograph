(ns chronograph.viewport
  (:require [goog.dom :as dom]
            [goog.events :as events])
  (:import [goog.events EventType]))

(defn size []
  (let [s (dom/getViewportSize)]
    [(.-width s) (.-height s)]))

(defn on-resize! [f]
  (events/listen js/window EventType.RESIZE f))
