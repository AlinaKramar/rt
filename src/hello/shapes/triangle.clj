(ns hello.shapes.triangle
  (:use hello.shapes.shape))

(extend Triangle [a b c] Shape
  (extend-protocol intersection [ray trngl]
    ()))