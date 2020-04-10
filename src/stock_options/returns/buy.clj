(ns stock-options.returns.buy
  (:require [stock-options.returns.shared :refer [losses shift-price]]))

(defn buy-profit
  [option price-shift]
  (- (shift-price option price-shift)
     (:strike option)
     (:premium option)))

(defn buy-viable?
  [option price-shift]
  (> (shift-price option price-shift)
     (:strike option)))

(defn returns
  [option price-shift]
  (if (buy-viable? option price-shift)
    (buy-profit option price-shift)
    (losses option)))
