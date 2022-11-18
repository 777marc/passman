(ns passman.app
  (:require [clojure.tools.cli :refer [parse-opts]]))

(def cli-options
  [[nil "--list"]])

(defn -main [& args]
  (let [parsed-options (parse-opts args cli-options)
        options (:options parsed-options)]
    (cond
      (:list options) (println "list stored passwords"))))
