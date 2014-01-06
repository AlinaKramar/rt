(ns rt.shapes.shape)

(defprotocol intersection
  (ray-intersection [this ray]))
