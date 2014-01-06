(ns rt.scene
  (:use rt.vector)
  (:use rt.ray))

(defrecord Camera [o n k f])

(defrecod Screen [n m length width])

(defrecord Scene [camera screen shapes]
  (view-ray [this i j]
    (let [camera-origin (:o (:camera this))
          camera-dir (:k (:camera this))
          camera-up-dir (:n (:camera this))
          focus (:f (:camera this))
          screen-length (:length (:screen this))
          screen-width (:width (:screen this))
          pixel-length (/ screen-length (:n (:screen this)))
          pixel-width (/ screen-width (:m (:screen this)))
          camera-direction (normalize (sub camera-dir camera-origin))
          camera-right-direction (normalize (cross camera-direction camera-up-dir))
          screen-center (sum camera-origin (mult focus camera-direction))
          top-border-center (sum screen-center (mult (/ screen-width 2)))
          top-left-angel (sum top-border-center (mult (/ screen-length 2) camera-right-direction))
          i-strip-top (sub top-left-angle (mult (* i pixel-length) camera-right-direction))
          i-j-pixel (sub i-strip-top (mult (* j pixel-width) camera-up-dir))]

          (->Ray camera-origin (normalize (sub i-j-pixel camera-origin))))))
