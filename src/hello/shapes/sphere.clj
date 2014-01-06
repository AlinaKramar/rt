(ns hello.shapes.sphere
  (:use hello.shapes.shape)
  (:use hello.vector)
  (:use hello.ray)
  (:require [clojure.math.numeric-tower :as math]))

(defrecord Sphere [o r]
    intersection
    (ray-intersection [this ray]
      (let [{:keys [o r]} this
            {:keys [s direction]} ray
            sd (dot s direction)
            od (dot o direction)
            sd-od (- sd od)
            sqrd (dot direction direction)
            sqrs (dot s s)
            sqro (dot o o)
            sqrr (* r r)
            dscr (- (* sd-od sd-od) (* sqrd (- sqro sqrr (* 2 (dot s o)) sqrs)))]
        (if (< dscr 0)
          0
          (let [t1 (/ (+ (- sd-od) (math/sqrt dscr)) sqrd)
                t2 (/ (- (- sd-od) (math/sqrt dscr)) sqrd)]
            (cond
             (< (* t1 t2) 0) (max t1 t2)
             (t1 > 0) (min t1 t2)
             :else 0))))))
