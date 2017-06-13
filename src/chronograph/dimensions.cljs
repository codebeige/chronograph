(ns chronograph.dimensions)

(defn scale-to-fit [[w h] [vw vh]]
  (let [r (Math/min (/ vw w) (/ vh h))]
    [(* r w) (* r h)]))

(defn bounding-box [w h]
  (scale-to-fit [31 16] (map #(* 0.9 %) [w h])))

(defn init [vw vh]
  (let [[w h] (bounding-box vw vh)]
    {:width w
     :height h
     :x (/ (- vw w) 2)
     :y (/ (- vh h) 2)}))
