(ns rt.shapes.sphere
  (:use rt.shapes.shape)
  (:use rt.vector)
  (:use rt.ray)
  (:require [clojure.math.numeric-tower :as math]))

(defrecord Sphere [center radius]
    intersection
    (ray-intersection [this ray]
      (let [{:keys [center radius]} this
            {:keys [origin direction]} ray
            od (dot origin direction)
            cd (dot center direction)
            od-cd (- od cd)
            sqrd (dot direction direction)
            sqro (dot origin origin)
            sqrc (dot center center)
            sqrr (* radius radius)
            dscr (- (* od-cd od-cd) (* sqrd (- sqro sqrr (* 2 (dot origin center)) sqrc)))]
        (if (neg? dscr)
          0
          (let [t1 (/ (+ (- od-cd) (math/sqrt dscr)) sqrd)
                t2 (/ (- (- od-cd) (math/sqrt dscr)) sqrd)]
            (cond
             (neg? (* t1 t2)) (max t1 t2)
             (pos? t1) (min t1 t2)
             :else 0))))))
