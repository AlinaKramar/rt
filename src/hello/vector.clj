(ns hello.vector
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

(defn cross [a b]
  (Vector. (- (* :y a :z b) (* :z a :y b)) (- (* :z a :x b) (* :x a :z b)) (- (* :x a :y b) (* :y a :x b))))
