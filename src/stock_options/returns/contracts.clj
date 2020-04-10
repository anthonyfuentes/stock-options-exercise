(ns stock-options.returns.contracts
  (:require [stock-options.returns.buy :as buy])
  (:require [stock-options.returns.sell :as sell]))

(def type-fn-map
  {:sell sell/returns
   :buy buy/returns})

(defn get-type-fn
  [option]
  ((:type option) type-fn-map))

(defn return
  [option price-shift]
  (* 100 ((get-type-fn option) option price-shift)))

(defn rounded-return
  [option price-shift]
  (format "%.2f" (return option price-shift)))

(defn record-return
  [report price-shift option]
  (assoc
    report
    (* 100 price-shift)
    (rounded-return option price-shift)))

(defn returns
  [option price-shifts]
  (reduce
    #(record-return %1 %2 option)
    {}
    price-shifts))
