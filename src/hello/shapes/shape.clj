(ns hello.shapes.shape)

(defprotocol intersection
  (ray-intersection [this ray]))

