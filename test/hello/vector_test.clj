(:use 'clojure.test)

(deftest add-test
  (def a
    (->Vector 1 1 1))
  (def b
    (->Vector 2 2 2))
  (def s
    (->Vector 3 3 3))
  (assert (= s (sum a b)))
  )