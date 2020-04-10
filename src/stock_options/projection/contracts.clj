(ns stock-options.projection.contracts
  (:require [stock-options.returns.contracts :refer [returns]]))

(defn project-return
 [option price-shifts]
 {:ticker (:ticker option)
  :returns (returns option price-shifts)})

(defn project-returns
  [options price-shifts]
  (map #(project-return % price-shifts) options))
