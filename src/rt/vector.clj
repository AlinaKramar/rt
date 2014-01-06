(ns rt.vector
  (:require [clojure.math.numeric-tower :as math]))

(defrecord Vector [x y z])

(defn sum [a b]
  (merge-with + a b))

(defn sub [a b]
  (merge-with - a b))

(defn mult [alpha v]
  (merge-with * v (->Vector alpha alpha alpha)))

(defn dot [a b]
  (apply + (map val (merge-with * a b))))

(defn length [v]
  (math/sqrt (dot v v)))

(defn normalize [v]
  (mult (/ 1 (length v)) v))

(defn cross [v1 v2]
  ;; x y z
  ;; a b c
  (let [{x :x y :y z :z} v1
        {a :x b :y c :z} v2]
    (->Vector (- (* y c) (* z b))
              (- (* z a) (* x c))
              (- (* x b) (* y a)))))
