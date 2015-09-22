(ns lab-notebook.core
  (:require [om.core :as om]
            [om.dom :as dom]))

(defonce appstate (atom {}))

(defn app-container [cursor component]
  (reify
    om/IRender
    (render [this]
      (dom/div nil (:msage cursor)
               (dom/h1 nil "JLLO")
               (dom/h1 nil "nedlo")
               (dom/h1 nil "wdzzup")
               (dom/h1 nil "yoyo")))))

(om/root app-container appstate
  {:target (. js/document (getElementById "app"))})
