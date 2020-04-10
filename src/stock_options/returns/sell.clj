(ns stock-options.returns.sell
  (:require [stock-options.returns.shared :refer [losses shift-price]]))

(defn sell-profit
  [option price-shift]
  (- (:strike option)
     (shift-price option price-shift)
     (:premium option)))

(defn sell-viable?
  [option price-shift]
  (> (:strike option)
     (shift-price option price-shift)))

(defn returns
  [option price-shift]
  (if (sell-viable? option price-shift)
    (sell-profit option price-shift)
    (losses option)))

