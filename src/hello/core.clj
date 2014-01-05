(ns hello.core
 (:use hello.vector)
  (:use hello.shapes.shape)
  (:use hello.shapes.sphere)
  (:use hello.ray))

(def center (->Vector 0 0 0))
(def ray (->Ray center (->Vector 1 1 1)))
(def sphere (->Sphere center 2))

(defn -main []
  (println (ray-intersection sphere ray)))