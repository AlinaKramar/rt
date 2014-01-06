(ns rt.io.displays
  (:use  rt.color))

(import 'java.awt.image.BufferedImage
        'javax.imageio.ImageIO
        'java.awt.Color
        'java.io.File)


(defn bitmap2console [bitmap]
  (doseq [row (:data bitmap)]
    (do
      (doseq [color row]
        (print (if (< 0.5 (value color)) "X" " ")))
     (println))))

(defn bitmap2screen [bitmap]
  (let [{:keys [width height data]} bitmap
        img (BufferedImage. width height BufferedImage/TYPE_INT_ARGB)
        raster (.getRaster img)]
    (do
      (doseq [x (range width)
              y (range height)]
        (.setPixel raster x y (double-array [100 0 100 255])))
      (ImageIO/write img "png" (File. "test.png")))))
