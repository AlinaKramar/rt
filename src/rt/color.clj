(ns rt.color)

(defrecord Color [r g b])

(defn norm [c]
  (apply ->Color (map #(-> % (max 0) (min 1)) (vals c))))

(defn value [c]
  (/ (apply + (vals c)) 3))

(def z 0.05)
(def o 0.7)
(def red   (->Color o z z))
(def green (->Color z o z))
(def blue  (->Color z z o))
(def black  (->Color z z z))
(def white  (->Color o o o))

(defrecord Bitmap [width height data])

(defn bitmap [width height f]
  (->Bitmap width height
            (vec (for [y (range height)]
                   (vec (for [x (range width)] (f x y)))))))

(defn chess [width height side]
    (bitmap width height #(if (even? (+ (quot %1 side) (quot %2 side)))
                            black
                            white)))
