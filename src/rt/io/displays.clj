(ns rt.io.displays
  (:use  rt.color))

(defn bitmap2console [bitmap]
  (doseq [row bitmap]
    (do
      (doseq [color row]
        (print (if (< 0.5 (value color)) "X" " ")))
     (println))))
