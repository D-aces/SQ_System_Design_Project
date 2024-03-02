#!/bin/bash

kubectl create -f docker-deploy.yaml

kubectl create -f docker-service.yaml
