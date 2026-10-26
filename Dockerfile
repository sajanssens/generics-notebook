FROM jupyter/base-notebook:python-3.11

USER root
RUN apt-get update && apt-get install -y --no-install-recommends \
    openjdk-17-jdk \
    curl \
    unzip \
 && apt-get clean \
 && rm -rf /var/lib/apt/lists/*

USER ${NB_UID}
RUN curl -fL https://github.com/SpencerPark/IJava/releases/download/v1.3.0/ijava-1.3.0.zip -o /tmp/ijava.zip \
 && unzip /tmp/ijava.zip -d /tmp/ijava \
 && python /tmp/ijava/install.py --sys-prefix \
 && rm -rf /tmp/ijava /tmp/ijava.zip