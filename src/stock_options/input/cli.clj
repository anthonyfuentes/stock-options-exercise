(ns stock-options.input.cli
  (:require [clojure.string :refer [split]])
  (:require [stock-options.casting.numbers :refer [->number]]))

(defn parse-shifts
  [price-shifts]
  (map ->number (split price-shifts #",")))
