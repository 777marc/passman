(ns passman.db
  (:require [babashka.pods :as pods]))

(pods/load-pod 'org.babashka/go-sqlite3 "0.1.0")

(require '[pod.babashka.go-sqlite3 :as sqlite])