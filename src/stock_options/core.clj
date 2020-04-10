(ns stock-options.core
  (:require [stock-options.input.cli :refer [parse-shifts]])
  (:require [stock-options.input.csv :refer [vectorize]])
  (:require [stock-options.labeling.vectors :refer [label-options]])
  (:require [stock-options.casting.maps :refer [cast-options]])
  (:require [stock-options.casting.numbers :refer [->number]])
  (:require [stock-options.projection.contracts :refer [project-returns]]))

(defn -main
  [& [filepath shifts]]
  (-> filepath
      vectorize
      label-options
      cast-options
      (project-returns (parse-shifts shifts))
      println))
