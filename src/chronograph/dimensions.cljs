(ns chronograph.dimensions)

(defn scale-to-fit [[w h] [vw vh]]
  (let [r (Math/min (/ vw w) (/ vh h))]
    [(* r w) (* r h)]))

(defn bounding-box [w h]
  (scale-to-fit [31 16] (map #(* 0.9 %) [w h])))

(defn init [vw vh]
  (let [[width height] (bounding-box vw vh)
        weight         (/ width 460)
        length         (* 7.3 weight)
        offset         (* 2.5 weight)]
    {:margin (map #(/ (- %1 %2) 2) [vw vh] [width height])
     :weight weight
     :length length
     :offset offset
     :group (* 5 offset)
     :row (* 1.5 length)
     :block (* 63 offset)
     :section (* 18 length)}))
