(ns hello.core-test
  (:use hello.vector)
  (:require [clojure.test :refer :all]
            [hello.core :refer :all]))

(deftest add-test
  (def a
    (->Vector 1 1 1))
  (def b
    (->Vector 2 2 2))
  (def s
    (->Vector 3 3 3))
  (assert (= s (sum a b)))
  )

(deftest exseption-test
  (is (thrown? Exception (sub (->Vector 1 2 3) 0))))

(deftest mult-test
  (def a
    0)
  (def b
    (->Vector 2 2 2))
  (def res
    (->Vector 0 0 0))
  (assert (= res (mult a b)))
  )

(deftest mult-one-test
  (def a
    1)
  (def b
    (->Vector 2 2 5))
  (assert (= b (mult a b)))
  )
