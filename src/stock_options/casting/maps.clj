(ns stock-options.casting.maps
  (:require [stock-options.casting.numbers :refer [->number]]))

(def cast-map
  {
   :ticker str
   :current ->number
   :type keyword
   :strike ->number
   :expiry str
   :premium ->number
   })

(defn cast-values
  [casted-option [label value]]
  (assoc
    casted-option
    label
    ((label cast-map) value)))

(defn cast-option
  [option]
  (reduce cast-values {} option))

(defn cast-options
  [options]
  (map cast-option options))
