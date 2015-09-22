(defproject lab-notebook "0.1.0-SNAPSHOT"
  :description "Lab Notebook in ClojureScript to accompany LispCast
  Single Page Applications with ClojureScript and Om"
  :url "http://purelyfunctional.tv/single-page-applications"
  :license {:name "Creative Commons Zero"
            :url "http://creativecommons.org/publicdomain/zero/1.0/"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.122"]
                 [org.omcljs/om "0.8.8"]]
  :plugins [[lein-cljsbuild "1.0.5"]
            [lein-figwheel "0.4.0"]]
  :figwheel {:nrepl-port 7888
             :nrepl-middleware ["cider.nrepl/cider-middleware"
                                "refactor-nrepl.middleware/wrap-refactor"
                                "cemerick.piggieback/wrap-cljs-repl"]}
  :target-path "target/%s"
  :clean-targets ^{:protect false} [:target-path "out"]
  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src"]
                        :figwheel true
                        :compiler {:main lab-notebook.core}
                        :optimizations nil}
                       {:id "prod"
                        :source-paths ["src"]
                        :compiler {:optimizations :advanced
                                   :output-to "target/js"}
                        :externs ["marked.min.js"]}]}
  :profiles {:dev {:plugins [[cider/cider-nrepl "0.9.1"]]
                   :dependencies [[com.cemerick/piggieback "0.2.1"]
                                  [org.clojure/tools.nrepl "0.2.10"]]
                   :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}}})
