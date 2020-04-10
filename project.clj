(defproject stock-options "0.1.0-SNAPSHOT"
  :description "tool for calculating possible option returns"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/data.csv "1.0.0"]]
  :main stock-options.core
  :repl-options {:init-ns stock-options.core})
