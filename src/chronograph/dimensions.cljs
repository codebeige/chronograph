(ns chronograph.dimensions)

(defn scale-to-fit [[w h] [vw vh]]
  (let [r (Math/min (/ vw w) (/ vh h))]
    [(* r w) (* r h)]))

(defn bounding-box [w h]
  (scale-to-fit [18 10] (map #(* 0.9 %) [w h])))

(defn init [vw vh]
  (let [[width height] (bounding-box vw vh)
        weight         (/ width 460)
        length         (* 7.4 weight)
        offset         (* 2.5 weight)]
    {:box     [width height]
     :margin  (map #(/ (- %1 %2) 2) [vw vh] [width height])
     :section (* 20 length)
     :block   (* 63 offset)
     :row     (* 1.5 length)
     :group   (* 5 offset)
     :offset  offset
     :weight  weight
     :length  length}))
