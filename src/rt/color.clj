(ns rt.color)

(defrecord Color [r g b])

(defn norm [c]
  (apply ->Color (map #(-> % (max 0) (min 1)) (vals c))))
