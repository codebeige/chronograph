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
    {:block     (* 63 offset)
     :box       [width height]
     :clock     (map #(/ % 2) [vw vh])
     :font-size (* 2 length)
     :group     (* 5 offset)
     :length    length
     :margin    (map #(/ (- %1 %2) 2) [vw vh] [width height])
     :offset    offset
     :row       (* 1.5 length)
     :section   (* 20 length)
     :weight    weight}))
