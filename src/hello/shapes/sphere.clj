(ns hello.shapes.sphere
  (:use hello.shapes.shape)
  (:use hello.vector)
  (:use hello.ray)
  (:require [clojure.math.numeric-tower :as math]))

(defmacro dbg [body]
  `(let [x# ~body]
     (println "dbg:" '~body "=" x#)
     x#))

(defrecord Sphere [o r]
    intersection
    (ray-intersection [this ray]
      (let [s (:s ray) o (:o this) d (:direction ray) r (:r this)]

        (let [sd (dot s d) od (dot o d)]
          (let [sd-od (- sd od) sqrd (dot d d) sqrs (dot s s) sqro (dot o o) sqrr (* r r)]
            (let [dscr (- (* sd-od sd-od) (* sqrd (- sqro sqrr (* 2 (dot s o)) sqrs)))]

                  (if (< dscr 0)
                    0
                    (let [t1 (/ (+ (- sd-od) (math/sqrt dscr)) sqrd) t2 (/ (- (- sd-od) (math/sqrt dscr)) sqrd)]
                      (if (< (* t1 t2) 0)
                        (max t1 t2)
                        (if (> t1 0)
                            (min t1 t2)
                            0))))))))))

