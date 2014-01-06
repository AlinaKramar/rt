(ns rt.shapes.triangle
  (:use rt.shapes.shape))

(extend Triangle [a b c] Shape
  (extend-protocol intersection [ray trngl]
    ()))
