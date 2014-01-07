(ns rt.core
  (:use rt.vector)
  (:use rt.shapes.shape)
  (:use rt.shapes.sphere)
  (:use rt.ray)
  (:use rt.color)
  (:use rt.io.displays))

(def center (->Vector 0 0 0))
(def ray (->Ray center (->Vector 1 1 1)))
(def sphere (->Sphere center 2))

(defn -main []
  (println (ray-intersection sphere ray)))
