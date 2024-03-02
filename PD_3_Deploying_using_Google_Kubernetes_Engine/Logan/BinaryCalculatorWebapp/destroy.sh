#!/bin/bash

kubectl delete -f docker-service.yaml

kubectl delete -f docker-deploy.yaml
